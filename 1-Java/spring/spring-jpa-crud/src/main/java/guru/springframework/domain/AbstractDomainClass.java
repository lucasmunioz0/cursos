package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jt on 12/16/15.
 */
@MappedSuperclass
@Data
public class AbstractDomainClass implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Version
    private Integer version;
    private Date dateCreated;
    private Date lastUpdated;

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }
}
