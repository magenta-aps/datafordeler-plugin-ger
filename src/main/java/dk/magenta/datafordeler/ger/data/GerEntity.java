package dk.magenta.datafordeler.ger.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.DatabaseEntry;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.core.database.IdentifiedEntity;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.Collection;

@MappedSuperclass
public class GerEntity extends DatabaseEntry implements IdentifiedEntity {

    public static final String DB_FIELD_IDENTIFICATION = "identification";
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    protected Identification identification;

    @Override
    public Identification getIdentification() {
        return this.identification;
    }

    @Override
    public void forceLoad(Session session) {
    }

    @Override
    public IdentifiedEntity getNewest(Collection<IdentifiedEntity> collection) {
        return null;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }


    public static final String DB_FIELD_CODE = "ger";
    public static final String IO_FIELD_CODE = "gerNr";
    @Column(name = DB_FIELD_CODE)
    @JsonProperty
    private int ger;

    public int getGer() {
        return this.ger;
    }

    @JsonProperty(value = "ger")
    public void setGer(int ger) {
        this.ger = ger;
    }
}
