package dk.magenta.datafordeler.ger.data.responsible;

import dk.magenta.datafordeler.core.fapi.FapiBaseService;
import dk.magenta.datafordeler.core.io.ImportMetadata;
import dk.magenta.datafordeler.ger.data.GerEntityManager;
import dk.magenta.datafordeler.ger.data.RawData;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("GerParticipantEntityManager")
public class ResponsibleEntityManager extends GerEntityManager<ResponsibleEntity> {

    public ResponsibleEntityManager() {
    }

    @Override
    protected String getBaseName() {
        return "responsible";
    }

    @Override
    public FapiBaseService getEntityService() {
        return null;
    }

    @Override
    public String getDomain() {
        return "https://data.gl/ger/responsible/1/rest";
    }

    @Override
    protected String getSheetName() {
        return "Ansvarlige";
    }

    @Override
    public String getSchema() {
        return ResponsibleEntity.schema;
    }

    @Override
    protected Class<ResponsibleEntity> getEntityClass() {
        return ResponsibleEntity.class;
    }

    @Override
    protected UUID generateUUID(RawData rawData) {
        return ResponsibleEntity.generateUUID(rawData.getInt("GERNR"));
    }

    @Override
    protected ResponsibleEntity createBasicEntity(RawData record, Session session) {
        return new ResponsibleEntity(record);
    }

    @Override
    protected void updateEntity(ResponsibleEntity entity, RawData rawData, ImportMetadata importMetadata) {
        entity.setOperationFormCode(rawData.getInt("DRIFTFORMKODE"));
        entity.setOperationFormText(rawData.getString("DRIFTFORMTEKST"));
        entity.setJeEndDate(rawData.getDate("JE_SLUTDTO"));
        entity.setRelationMemo(rawData.getString("RELATIONSNOTAT"));
        entity.setRelationStartDate(rawData.getDate("RELATIONSSTART"));
        entity.setRelationEndDate(rawData.getDate("RELATIONSSLUT"));
        entity.setRelationCreateDate(rawData.getDate("RELATIONOPRETTET"));
        entity.setRelationUpdateDate(rawData.getDate("RELATIONOPDATERET"));
        entity.setCvrParticipantGuid(rawData.getUUID("CVR_DELTAGER_GUID"));
        entity.setUnitNumber(rawData.getInt("ENHEDSNUMMER"));
        entity.setUnitType(rawData.getString("ENHEDSTYPE"));
        entity.setName(rawData.getString("NAVN"));
        entity.setCprNumber(rawData.getInt("CPRNUMMER"));
        entity.setCvrNumber(rawData.getInt("CVRNUMMER"));
        entity.setLastUpdated(rawData.getDate("SIDSTOPDATERET"));
    }

}
