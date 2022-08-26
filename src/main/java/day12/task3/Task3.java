package day12.task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<MusicBand> bands = new ArrayList<>();
        for (int i=0; i<12; i++){
            bands.add(new MusicBand("name "+i, 1980 + i*3));
        }
        System.out.println(bands);
        bands = groupsAfter2000(bands);
        System.out.println(bands);
    }
    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands){
        List<MusicBand> bandsAfter2000 = new ArrayList<>();
        for (MusicBand band : bands){
            if (band.getYear()>2000)
                bandsAfter2000.add(band);
        }
        return bandsAfter2000;
    }
}
