class Oseba{

    String ime, priimek;
    char spol;
    int letoRojstva;
    Oseba oce, mati;
    static int steviloUstvarjenih = 0;

    public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati){
        this.ime = ime;
        this.priimek = priimek;
        this.spol = spol;
        this.letoRojstva = letoRojstva;
        this.oce = oce;
        this.mati = mati;

        steviloUstvarjenih++;
    }

    public Oseba(String ime, String priimek, char spol, int letoRojstva){
        this(ime, priimek, spol, letoRojstva, null, null);
    }

    public String vrniIme(){
        return this.ime;
    }
    public void nastaviIme(String novoIme){
        ime = novoIme;
    }

    public String toString(){
        //return ime + " " + priimek + " (" + spol + "), " + String(letoRojstva);
        return String.format("%s %s (%s), %d", ime, priimek, spol, letoRojstva);
    }

    public int starost(int leto){
        return leto - letoRojstva;
    }

    public boolean jeStarejsaOd(Oseba os){
        return (this.letoRojstva < os.letoRojstva);
    }

    public Oseba vrniOceta(){
        return ((oce == null)? null : oce);
    }

    public String imeOceta(){
        return ((oce == null)? null : oce.vrniIme());
    }
    public boolean jeBratAliSestraOd(Oseba os){

        if(this == os){return false;}

        if(this.oce == os.vrniOceta() && this.mati == os.mati){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean jeSestraOd(Oseba os){

        if(spol == 'M'){return false;}
        else if(this == os){return false;}
        else{
            return jeBratAliSestraOd(os);
        }

    }

    public boolean jeTetaOd(Oseba os){
        if(spol == 'M'){
            return false;
        }
        else if(jeSestraOd(os.mati) || jeSestraOd(os.vrniOceta())){
            return true;
        }
        return false;
    }

    public boolean jeOcetovskiPrednikOd(Oseba os){

        Oseba current  = os;
        if(spol == 'Z'){
            return false;
        }

        while(current != null){

            if(this == current.vrniOceta()){
                return true;
            }
            // if(this.ime == current.vrniOceta().ime && this.priimek == current.vrniOceta().priimek){
            //     return true;
            // }
            
            current = current.vrniOceta();
        }
        return false;
    }

    public static int steviloUstvarjenih(){
        return steviloUstvarjenih;
    }
}