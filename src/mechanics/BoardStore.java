package mechanics;

import java.util.ArrayList;

public class BoardStore {



    public static final Board createBoard(String inString) {

        ArrayList<String> list = new ArrayList<String>();

        if(inString.equals("nivel 1")){
            list.add("RUBY");
            list.add("ROSE");
            list.add("BROOM");
            list.add("TANK");
            list.add("PHONE");
            list.add("WATER");
            char[][] tempchar = {
                    {'R', 'E', 'T', 'M', 'Y', 'E'},
                    {'B', ' ', 'P', 'K', 'B', 'S'},
                    {'A', 'W', 'A', 'O', 'U', 'T'},
                    {'N', 'T', 'O', 'O', 'S', 'N'},
                    {'R', 'E', 'R', 'R', 'O', 'M'},
                    {'R', 'H', 'E', 'N', 'R', 'Y'}
            };
            return new Board(list, tempchar);

        }else if(inString.equals("nivel 2")){
            list.add("srt1");
            list.add("srt2");
            list.add("srt3");
            list.add("srt4");
            char[][] tempchar = {
                    {'R', 'E', 'T', 'K', 'Y', 'E'},
                    {'U', ' ', 'P', 'N', 'B', 'S'},
                    {'B', 'R', 'T', 'A', 'N', 'K'},
                    {'Y', 'O', 'O', 'T', 'S', 'N'},
                    {'R', 'S', 'R', 'R', 'O', 'M'},
                    {'R', 'E', 'E', 'N', 'R', 'Y'}
            };
            return new Board(list, tempchar);

        }else if(inString.equals("nivel 3")){

        }else if(inString.equals("nivel 4")){

        }else if(inString.equals("nivel 5")){

        }

        return null;
    }

}
