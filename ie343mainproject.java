
package Work;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Work.HeuristicSolve;
import Work.Track;



public class Main {
        public static void main(String[] args) throws IOException{
                List<List<String>> list = readValues();
                System.out.println(list.get(0));
		List<Integer> valueList = new ArrayList<Integer>();
		List<Integer> weightList = new ArrayList<Integer>();
		for(int i=1;i<list.size();i++) {
			valueList.add(Integer.parseInt(list.get(i).get(4))); 
			weightList.add(Integer.parseInt(list.get(i).get(5)));
			}
		List<List<String>> list1 = readSequential();
		List<ArrayList<Double>> sequential_data = new ArrayList<ArrayList<Double>>();
			ArrayList<Track> Tracks = new ArrayList<>();//Creating an Arraylist for add all tracks.
			double OneDimensionTrackValues [][] = new double[50][50]; // Track values for each track.

		for (int i=1;i<list1.size();i++){
			ArrayList<Double> row = new ArrayList<>();
			for (int j=1;j<list1.get(0).size();j++){
				row.add(Double.parseDouble(list1.get(i).get(j)));

			}
			sequential_data.add(row);
		}
		System.out.println(sequential_data.get(0).get(1));

		// Continue From There


			//Creating Track Objects.
			for (int i =1 ; i < list1.size();i++){
				for (int j =1 ; j < list1.get(0).size();j++ ){
					if (Tracks.size()<50){
						Track track = new Track(Integer.parseInt(list.get(j).get(0)),Integer.parseInt(list.get(j).get(5)),Integer.parseInt(list.get(j).get(4)),OneDimensionTrackValues[j-1]);
						Tracks.add(track);
					}else {
						break;
					}
				}
			}

			Solve(Tracks); //Solving Heuristic way.



        }
        public static List<List<String>> readValues() throws IOException { 
                try
		{
			List< List<String> > data = new ArrayList<>();//list of lists to store data
			String file = "Work/term_project_value_data.csv";//file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Reading until we run out of lines
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split(","));//splitting lines
				data.add(lineData);
				line = br.readLine();
			}
			
			//printing the fetched data
			for(List<String> list : data)
			{
				for(String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
                        return data;
		}
		catch(Exception e)
		{
			System.out.print(e);
                        List< List<String> > data = new ArrayList<>();//list of lists to store data
                        return data;
		}
                
        }
	public static List<List<String>> readSequential() throws IOException { 
                try
		{
			List< List<String> > data = new ArrayList<>();//list of lists to store data
			String file = "Work/term_project_sequential_data.csv";//file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Reading until we run out of lines
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split(","));//splitting lines
				data.add(lineData);
				line = br.readLine();
			}
			
			//printing the fetched data
			for(List<String> list : data)
			{
				for(String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
                        return data;
		}
		catch(Exception e)
		{
			System.out.print(e);
                        List< List<String> > data = new ArrayList<>();//list of lists to store data
                        return data;
		}
                
        }

        public static double Solve(ArrayList<Track> AllTracks){

        	int RemainingDurationTime =  1800000;
        	double TotalAlbumValue= 0;
        	ArrayList<Track> AddedTracks = new ArrayList<>();
			Track currentBest =AllTracks.get(0);
			int currentBestTime=AllTracks.get(0).track_duration;

        	while(RemainingDurationTime > 0 && RemainingDurationTime-currentBestTime > 0){

				for(int i=0;i<AllTracks.size();i++){
					if (AllTracks.get(i).track_individual_value >= currentBest.track_individual_value ){
						//if (AllTracks.get(i).track_duration <= currentBest.track_duration)
							currentBest=AllTracks.get(i);
					}//{
					//	continue;
					//}

				}


					RemainingDurationTime=RemainingDurationTime-currentBestTime;
				if (RemainingDurationTime>0){

					TotalAlbumValue =TotalAlbumValue+currentBest.track_individual_value;
					AllTracks.remove(currentBest);
					AddedTracks.add(currentBest);
					currentBest=AllTracks.get(0);
				}

				int a;
        	}
   TotalAlbumValue=TotalAlbumValue-(RemainingDurationTime/60)*0.02;

        	System.out.println("Total Album Value :	" +TotalAlbumValue);

        	return TotalAlbumValue;

		}


}

