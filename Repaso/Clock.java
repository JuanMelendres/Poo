public class Clock{
	private int hr,
				min,
				sec;
	public Clock(){
		this(12,0,0);
	}
	public Clock(int hr, int min, int sec){
		setTime(hr,min,sec);
	}
	public void setTime(int hr, int min, int sec){
		if(hr >= 0  && hr < 24){
			this.hr = hr;
		}
		else{
			this.hr = 12;
		}
		if(min >= 0 && min < 60){
			this.min = min;
		}
		else{
			this.min = 0;
		}
		if(sec >= 0 && sec < 60){
			this.sec = sec;
		}
		else{
			this.sec = 0;
		}
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
	public void incrementHours(){
		this.hr=++this.hr%24;
	}
	public void incrementMinutes(){
		if(this.min < 59){
			this.min++;
		}
		else{
			this.min = 0;
			this.incrementHours();
		}
	}
	public void incrementSeconds(){
		if(this.sec < 59){
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
		this.hr = reloj.hr;
		this.min = reloj.min;
		this.sec = reloj.sec;
	}
	public Clock getCopy(){
		Clock nv = new Clock(this.hr,this.min,this.sec);
		return nv;
	}
}