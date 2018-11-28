
//63180178

public class Datum{

    int dan, mesec,leto;

    public Datum(int dan, int mesec, int leto){
        this.dan = dan;
        this.mesec = mesec;
        this.leto = leto;
    }

    public int vrniDan(){
        return this.dan;
    }

    public int vrniMesec(){
        return this.mesec;
    }

    public int vrniLeto(){
        return this.leto;
    }

    public boolean isYoungerThan(Datum datum){

        if(leto > datum.vrniLeto()){
            return true;
        }

        if(datum.vrniLeto() == leto){

            if(mesec > datum.vrniMesec()){
                return true;
            }
            else if(mesec == datum.vrniMesec()){
                if(dan > datum.vrniDan()){
                    return true;
                }
            }

        }
        return false;
    }

    public String toString(){

        String mesec = Integer.toString(this.mesec);
        String dan = Integer.toString(this.dan);

        if(this.mesec < 10){
            mesec = "0".concat(mesec);
        }
        if(this.dan < 10){
            dan = "0".concat(dan);
        }

        return String.format("%s.%s.%d", dan, mesec, leto);
    }

    public boolean jeEnakKot(Datum datum){
        return this.equals(datum);
    }

    

}