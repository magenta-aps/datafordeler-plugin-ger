package dk.magenta.datafordeler.ger.data.company;

import dk.magenta.datafordeler.core.fapi.FapiBaseService;
import dk.magenta.datafordeler.core.io.ImportMetadata;
import dk.magenta.datafordeler.ger.data.GerEntityManager;
import dk.magenta.datafordeler.ger.data.RawData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("GerCompanyEntityManager")
public class CompanyEntityManager extends GerEntityManager<CompanyEntity> {

    public CompanyEntityManager() {
    }

    @Override
    protected String getBaseName() {
        return "company";
    }

    @Override
    public FapiBaseService getEntityService() {
        return null;
    }

    @Override
    public String getDomain() {
        return "https://data.gl/ger/company/1/rest";
    }

    @Override
    protected String getSheetName() {
        return "JE";
    }

    @Override
    public String getSchema() {
        return CompanyEntity.schema;
    }

    @Override
    protected Class<CompanyEntity> getEntityClass() {
        return CompanyEntity.class;
    }

    @Override
    protected UUID generateUUID(RawData rawData) {
        return CompanyEntity.generateUUID(rawData.getInt("GERNR"));
    }

    @Override
    protected CompanyEntity createBasicEntity(RawData record, Session session) {
        return new CompanyEntity(record);
    }

    @Override
    protected void updateEntity(CompanyEntity entity, RawData rawData, ImportMetadata importMetadata) {
        entity.setValidated(rawData.getBoolean("VALIDERET"));
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
        entity.setOperationFormCode(rawData.getInt("DRIFTFORMKODE"));
        entity.setOperationFormText(rawData.getString("DRIFTFORMTEKST"));
        entity.setBusinessCode(rawData.getInt("BRANCHEKODE"));
        entity.setBusinessText(rawData.getString("BRANCHETEKST"));
        entity.setStartDate(rawData.getDate("STARTDTO"));
        entity.setEndDate(rawData.getDate("SLUTDTO"));
        entity.setLnr(rawData.getInt("LNR"));
        entity.setMemo(rawData.getString("NOTAT"));
        entity.setFoundDate(rawData.getDate("OPRETDTO"));
        entity.setAjourDate(rawData.getDate("AJOURDTO"));
        entity.setAjourInit(rawData.getString("AJOURINIT"));
        entity.setStatusGuid(rawData.getUUID("JE_STATUS_GUID"));
        entity.setStatusChange(rawData.getDate("JE_STATUS_CHANGE"));
        entity.setStatusInit(rawData.getString("JE_STATUS_INIT"));
        entity.setDoor(rawData.getString("SIDEDOER"));
        entity.setFloor(rawData.getInt("ETAGE"));
        entity.setLetterFrom(rawData.getCharacter("BOGSTAVFRA"));
        entity.setLetterTo(rawData.getCharacter("BOGSTAVTIL"));
        entity.setHouseNumberFrom(rawData.getInt("HUSNUMMERFRA"));
        entity.setHouseNumberTo(rawData.getInt("HUSNUMMERTIL"));
        entity.setRoadCode(rawData.getInt("VEJKODE"));
    }

}
