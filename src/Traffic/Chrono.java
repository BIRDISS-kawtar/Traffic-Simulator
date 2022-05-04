package Traffic;
import java.util.*;

public class Chrono {
	Calendar m_start = new GregorianCalendar();
	Calendar m_stop = new GregorianCalendar();
	Calendar m_check= new GregorianCalendar();
	int MAX=10;
	
	Chrono() {		
	}
	

	public void start() {
		m_start.setTime(new Date());
	}
	
	
	public void stop() {
		m_stop.setTime(new Date());
	}
	public void check() {
		m_check.setTime(new Date());
	}

	
	/*********millisecondes between start() and stop()************/
	public long getMilliSec() {
		return (m_stop.getTimeInMillis() - m_start.getTimeInMillis());
	}
	public long getMilliSec2() {
		return (m_check.getTimeInMillis() - m_start.getTimeInMillis());
	}
	public void printMilliSec() {
		if(getMilliSec() <= 0) {
			System.out.println("Vous n'avez pas arrété le chronomètre");
		} else {
			System.out.println("Temps d'exécution : " + getMilliSec() + " ms");
		}
	}
	public void printMilliSec2() {
		if(getMilliSec2() <= 0) {
			System.out.println("Vous n'avez pas arrété le chronomètre");
		} else {
			System.out.println("Temps d'exécution : " + getMilliSec2() + " ms");
		}
	}
	// Convert to realtime
	public long convertisseur(long l){
		return l*60000;
	}
	public long getLastPositif(long[] tab) {
		int i=0;
		while(i<MAX) {
			if(tab[i]<0) {
				break;
			}
			i++;
		}
		if(i==0) {
			return tab[i];
		}
		else{
			return tab[i-1];
		}
	}
	public int getLastPositifIndex(long[] tab) {
		int i=0;
		while(i<MAX) {
			if(tab[i]<0) {
				break;
			}
			i++;
		}
		return i-1;
	}
	public void changeLastPositif(long[] tab,long v) {
		int i=0;
		while(i<MAX) {
			if(tab[i]<0) {
				break;
			}
			i++;
		}
		if(i==0) {
			tab[i]=v;
		}
		else{
			tab[i-1]=v;
		}
	}
	
	public void addLastPositif(long[] tab,long v) {
		int i=0;
		while(i<MAX) {
			if(tab[i]<0) {
				break;
			}
			i++;
		}
		tab[i]=v;
	}
	public long[] ret(long d,long f) {
		long[] t= {d,f};
		return t;
	}
	
	
}
