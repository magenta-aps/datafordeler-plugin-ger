package dk.magenta.datafordeler.ger.data;

import dk.magenta.datafordeler.core.database.BaseLookupDefinition;
import dk.magenta.datafordeler.core.database.DataItem;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.core.exception.InvalidClientInputException;
import dk.magenta.datafordeler.core.fapi.BaseQuery;
import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lars on 19-05-17.
 */
public abstract class GerQuery<E extends GerEntity> extends BaseQuery {

    public static final String GERNR = "gernr";

    @QueryField(type = QueryField.FieldType.STRING, queryName = GERNR)
    private List<String> gerNr;

    public List<String> getGerNr() {
        return gerNr;
    }

    public void setGerNr(String gerNr) {
        this.gerNr.clear();
        this.addGerNr(gerNr);
    }

    public void addGerNr(String gerNr) {
        if (gerNr != null) {
            this.gerNr.add(gerNr);
            this.increaseDataParamCount();
        }
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(GERNR, this.gerNr);
        return map;
    }

    @Override
    public BaseLookupDefinition getLookupDefinition() {
        BaseLookupDefinition lookupDefinition = new BaseLookupDefinition(this);
        if (this.recordAfter != null) {
            lookupDefinition.put(DataItem.DB_FIELD_LAST_UPDATED, this.recordAfter, OffsetDateTime.class, BaseLookupDefinition.Operator.GT);
        }
        /*if (this.uuid != null && !this.uuid.isEmpty()) {
            lookupDefinition.put(
                    BaseLookupDefinition.entityref + BaseLookupDefinition.separator + GeoEntity.DB_FIELD_IDENTIFICATION + BaseLookupDefinition.separator + Identification.DB_FIELD_UUID,
                    this.uuid,
                    UUID.class,
                    BaseLookupDefinition.Operator.EQ
            );
        }*/
        if (this.gerNr != null) {
            lookupDefinition.put(
                    BaseLookupDefinition.entityref + BaseLookupDefinition.separator + GerEntity.DB_FIELD_CODE,
                    this.gerNr,
                    String.class
            );
        }
        return lookupDefinition;
    }

    @Override
    public void setFromParameters(ParameterMap parameters) throws InvalidClientInputException {
        this.setGerNr(parameters.getFirst(GERNR));
    }
}
