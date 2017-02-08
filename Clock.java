public class Clock{
    private int hr,
                min,
                sec;
    private String cd;
    public Clock(){
        this(12,0,0,"Guadalajara");
    }
    public Clock(int hr, int min, int sec, String cd){
        setTime(hr,min,sec);
        this.cd = cd;
    }
    public void setTime(int hr, int min, int sec){
        if(hr>=0 && hr<24){
            this.hr = hr;
        }
        else{
            this.hr = 12;
        }
        if(min>=0 && min<60){
            this.min = min;
        }
        else{
            this.min = 0;
        }
        if(sec>=0 && sec<60){
            this.sec = sec;
        }
        else{
            this.sec = 0;
        }
    }
    public void setCiudad(String cd){
        this.cd = cd;
    }
    public int getHours(){
        return this.hr;
    }
    public int getMinutes(){
        return this.min;
    }
    public int getSeconds(){
        return this.sec;
    }
    public void printTime(){
        System.out.println(this.hr+":"+this.min+":"+this.sec);
    }
    public String toString(){
        return this.cd+" "+this.hr+":"+this.min+":"+this.sec;
    }
    public void incrementHours(){
        // this.hr=(this.hr+1)%24;
        this.hr=++this.hr%24;
        // if(this.hr < 23){
        //     this.hr++;
        // }
        // else{
        //     this.hr = 0;
        // }
    }
    public void incrementMinutes(){
        if(this.min<59){
            this.min++;
        }
        else{
            this.min = 0;
            this.incrementHours();
        }
    }
    public void incrementSeconds(){
        if(this.sec<59){
            this.sec++;
        }
        else{
            this.sec = 0;
            this.incrementMinutes();
        }
    }
    public boolean equals(Clock reloj){
            return this.hr == reloj.hr && this.min == reloj.min && this.sec == reloj.sec;
    }
    public void makeCopy(Clock reloj){
        this.hr=reloj.hr;
        this.min=reloj.min;
        this.sec=reloj.sec;
    }
    public Clock getCopy(){
        Clock nvo = new Clock(this.hr,this.min,this.sec,this.cd);
        return nvo;
    }
}
