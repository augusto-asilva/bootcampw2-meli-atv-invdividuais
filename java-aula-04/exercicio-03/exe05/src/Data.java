import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Data {
    private GregorianCalendar gc;
    private Date data;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public Data(Date data){
        this.gc = new GregorianCalendar();
        this.gc.setTime(data);
        this.data = data;
    }

    public Data(String data){
        try {
            this.gc = new GregorianCalendar();
            this.gc.setTime(formatter.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getData(){
        return this.data;
    }

    private void add(int quantity, int unit){
        gc.add(quantity, unit);
        data = gc.getTime();
    }

    public void addDays(int quantity){
        add(quantity, Calendar.DAY_OF_MONTH);
    }

    public Integer compare(String data){
        try {
            return compare(formatter.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int compare(Date data){
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        return gc.compareTo(c);
    }

    @Override
    public String toString() {
        return formatter.format(data);
    }
}
