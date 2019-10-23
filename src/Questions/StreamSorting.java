package Questions;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class StreamSorting {

    private final Comparator<String> sorter ;
    private int maxChunkSize = 100000000;
    private List<File> outputs = new ArrayList<File>();
    private String tempDirectory = "";

    public StreamSorting(Comparator<String> sorter){
        this.sorter = sorter ;
    }

    public void setTempDirectory(String temp){
        tempDirectory = temp ;
        File file = new File(tempDirectory) ;
        if(!file.exists() || !file.isDirectory()){
           throw  new IllegalArgumentException("Parameter director is not a directory or does not exist") ;
        }
    }


    public void setMaxChunkSize(int size){
        this.maxChunkSize = size ;
    }

    public void splitChunks(InputStream in) throws IOException{
        outputs.clear();
        BufferedReader br = null ;
        List<String> lines = new ArrayList<>() ;

        try{
            br = new BufferedReader(new InputStreamReader(in)) ;
            String line = null ;
            int currentChunkSize = 0;
            while(br.readLine()!= null){
                lines.add(line) ;
                currentChunkSize= line.length() + 1;
                if(currentChunkSize>= maxChunkSize){
                    currentChunkSize = 0 ;
                    Collections.sort(lines , sorter);
                    File file = new File(tempDirectory+"temp"+System.currentTimeMillis()) ;
                    outputs.add(file) ;
                    writeOut(lines , new FileOutputStream(file)) ;
                    lines.clear();
                }
            }

            // write out the remaining chunk?????
            Collections.sort(lines , sorter);
            File file = new File(tempDirectory+"temp"+System.currentTimeMillis()) ;
            outputs.add(file) ;
            writeOut(lines , new FileOutputStream(file)) ;
            lines.clear();

        }
        catch (IOException e){
            throw e ;
        }
        finally{
            if(br!= null){
                try{
                    br.close();
                }
                catch (Exception e){}
            }
        }
    }


    private void writeOut(List<String> list , OutputStream os) throws IOException{
        BufferedWriter writer = null ;
        try{
            writer = new BufferedWriter(new OutputStreamWriter(os)) ;
            for(String s : list){
                writer.write(s);
                writer.write("\n");
            }
            writer.flush();

        }catch (IOException e){
            throw e ;
        }
        finally {
            if(writer!= null){
                try{
                    writer.close();
                }catch (Exception e){
                }
            }
        }
    }


    public void mergeChunks(OutputStream os) throws IOException{
        Map<StringWrapper, BufferedReader> map = new HashMap<>() ;
        List<BufferedReader> readers = new ArrayList<BufferedReader>() ;
        BufferedWriter writer = null ;
        ComparatorDelegate delegate = new ComparatorDelegate();
        try{
            writer = new BufferedWriter(new OutputStreamWriter(os)) ;
            for(int counter = 0 ; counter<outputs.size() ; counter++){
                BufferedReader reader = new BufferedReader(new FileReader(outputs.get(counter))) ;
                readers.add(reader) ;
                String line = reader.readLine() ;
                if(line != null){
                    map.put(new StringWrapper(line) , readers.get(counter)) ;
                }
            }

            List<StringWrapper> sorted = new LinkedList<StringWrapper>(map.keySet()) ;
            while(map.size()>0){
                Collections.sort(sorted , delegate);
                StringWrapper line = sorted.remove(0) ;
                writer.write(line.string);
                writer.write("\n") ;
                BufferedReader reader = map.remove(line) ;
                String nextLine = reader.readLine() ;
                if(nextLine != null){
                    StringWrapper sw = new StringWrapper(nextLine) ;
                    map.put(sw , reader) ;
                    sorted.add(sw) ;
                }

            }
        }catch (IOException e){
            throw  e;
        }
        finally {
            for(int counter = 0 ; counter<readers.size() ; counter++){
                try {
                    if(readers.get(counter)!=null){
                        readers.get(counter).close();
                    }
                }catch (Exception e){}
            }

            for(int counter = 0 ; counter < outputs.size() ; counter++){
                        outputs.get(counter).delete() ;
            }

            try{writer.close();}catch(Exception e){}

        }
    }

    private class ComparatorDelegate implements Comparator<StringWrapper>{
        public int compare(StringWrapper o1 , StringWrapper o2){
            return sorter.compare(o1.string , o2.string) ;
        }
    }


    private class StringWrapper implements Comparable<StringWrapper>{
        private final String string ;
        public StringWrapper(String line){
            this.string = line;
        }

        public int compareTo(StringWrapper o){
            return this.string.compareTo(o.string) ;
        }
    }


}
