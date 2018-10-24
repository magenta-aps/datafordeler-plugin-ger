package dk.magenta.datafordeler.ger.data.unit;

import dk.magenta.datafordeler.core.fapi.FapiBaseService;
import dk.magenta.datafordeler.core.io.ImportMetadata;
import dk.magenta.datafordeler.ger.data.GerEntityManager;
import dk.magenta.datafordeler.ger.data.RawData;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("GerAccessAddressEntityManager")
public class UnitEntityManager extends GerEntityManager<UnitEntity> {

    public UnitEntityManager() {
    }

    @Override
    protected String getBaseName() {
        return "accessaddress";
    }

    @Override
    public FapiBaseService getEntityService() {
        return null;
    }

    @Override
    public String getDomain() {
        return "https://data.gl/ger/unit/1/rest";
    }

    @Override
    protected String getSheetName() {
        return "PE";
    }

    @Override
    public String getSchema() {
        return UnitEntity.schema;
    }

    @Override
    protected Class<UnitEntity> getEntityClass() {
        return UnitEntity.class;
    }

    @Override
    protected UUID generateUUID(RawData rawData) {
        return UnitEntity.generateUUID(rawData.getInt("GERNR"));
    }

    @Override
    protected UnitEntity createBasicEntity(RawData record, Session session) {
        return new UnitEntity(record);
    }

    @Override
    protected void updateEntity(UnitEntity entity, RawData rawData, ImportMetadata importMetadata) {
        entity.setOperationFormCode(rawData.getInt("DRIFTFORMKODE"));
        entity.setOperationFormText(rawData.getString("DRIFTFORMTEKST"));
        entity.setJeEndDate(rawData.getDate("JE_SLUTDTO"));
        entity.setDeid(rawData.getUUID("DEID"));
        entity.setDnr(rawData.getInt("DNR"));
        entity.setJeid(rawData.getUUID("JEID"));
        entity.setValidated(rawData.getBoolean("VALIDERET"));
        entity.setCopy(rawData.getBoolean("KOPI"));
        entity.setName(rawData.getString("NAVN"));
        entity.setDanishName(rawData.getString("NAVN_DK"));
        entity.setShortName(rawData.getString("KORTNAVN"));
        entity.setShortDanishName(rawData.getString("KORTNAVN_DK"));
        entity.setCoName(rawData.getString("CONAVN"));
        entity.setAddress1(rawData.getString("ADR1"));
        entity.setAddress2(rawData.getString("ADR2"));
        entity.setAddress3(rawData.getString("ADR3"));
        entity.setBnr(rawData.getString("BNR", true));
        entity.setBoxNr(rawData.getString("BOXNR"));
        entity.setPostNr(rawData.getInt("POSTNR"));
        entity.setOldTaxKom(rawData.getInt("GAMMELSKATKOM"));
        entity.setMunicipalityCode(rawData.getInt("CPR_KOMKODE_2018"));
        entity.setLocalityCode(rawData.getInt("STEDKODE"));
        entity.setCountryCode(rawData.getInt("LANDKODE"));
        entity.setPhone(rawData.getString("TLFNR"));
        entity.setFax(rawData.getString("FAXNR"));
        entity.setMobilePhone(rawData.getString("MOBILNR"));
        entity.setEmail(rawData.getString("EMAIL"));
        entity.setBusinessText(rawData.getString("BRANCHETEKST"));
        entity.setBusinessCode(rawData.getInt("BRANCHEKODE"));
        entity.setStartDate(rawData.getDate("STARTDTO"));
        entity.setEndDate(rawData.getDate("SLUTDTO"));
        entity.setMemo(rawData.getString("NOTAT"));
        entity.setFoundDate(rawData.getDate("OPRETDTO"));
        entity.setAjourDate(rawData.getDate("AJOURDTO"));
        entity.setAjourInit(rawData.getString("AJOURINIT"));
        entity.setLuliNumber(rawData.getString("LULINR"));
    }

}
