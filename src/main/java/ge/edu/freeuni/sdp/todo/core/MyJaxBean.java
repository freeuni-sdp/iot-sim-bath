package ge.edu.freeuni.sdp.todo.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Babalah on 6/24/2016.
 */
@XmlRootElement
public class MyJaxBean {
    @XmlElement public String status;
    @XmlElement public String houseId;
}
