public class ZonaHoraria{
    private Clock[] zonaHoraria;
    public ZonaHoraria(){
        this.zonaHoraria = new Clock[10];
    }
    public void ponerHora(int pos, int hr, int min, int sec, String cd){
        if(this.zonaHoraria[pos] == null){
            this.zonaHoraria[pos] = new Clock(hr,min,sec,cd);
        }
        else{
            this.zonaHoraria[pos].setTime(hr,min,sec);
            this.zonaHoraria[pos].setCiudad(cd);
        }
    }
    public String toString(){
        String resultado = "";
        for(int i = 0; i <this.zonaHoraria.length; i++){
            if(this.zonaHoraria[i] != null){
                resultado+= this.zonaHoraria[i]+"\n";
            }
        }
        return resultado;
    }
    // public void imprimeZonasHorarias(){
    //
    // }
    public void cambiaHorarioInvierno(){
        for(int i = 0; i <this.zonaHoraria.length; i++){
            if(this.zonaHoraria[i] != null){
                this.zonaHoraria[i].incrementHours();
            }
        }
    }
    public static void main(String[] args) {
        ZonaHoraria zh = new ZonaHoraria();
        zh.ponerHora(0,10,26,30,"NY");
        zh.ponerHora(1,16,26,30,"Paris");
        zh.ponerHora(2,17,26,30,"Moscu");
        System.out.println(zh);
        zh.cambiaHorarioInvierno();
        System.out.println(zh);
    }
}
