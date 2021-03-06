package client.event;

import java.util.ArrayList;

public class Event {

    public void call() {
        final ArrayList<EventData> dl = EventManager.get(this.getClass());
        if (dl != null) {
             for (EventData data : dl){ 
                  try {
           data.target.invoke(data.source, this);
                  }
                  catch(Exception e) {
                  e.printStackTrace();
                  }
             }
        }
    }
}
