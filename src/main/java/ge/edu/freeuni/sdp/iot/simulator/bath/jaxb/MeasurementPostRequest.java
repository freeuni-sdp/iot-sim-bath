package ge.edu.freeuni.sdp.iot.simulator.bath.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MeasurementPostRequest {

    @XmlElement
    public double humidity;

    public void setMeasurement(double measurement) {
        this.humidity = measurement;
    }

    public double getMeasurement() {
        return humidity;
    }
}
