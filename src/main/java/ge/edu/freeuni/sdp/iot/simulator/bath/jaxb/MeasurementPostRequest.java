package ge.edu.freeuni.sdp.iot.simulator.bath.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MeasurementPostRequest {
    @XmlElement
    public double measurement;

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }

    public double getMeasurement() {
        return measurement;
    }
}
