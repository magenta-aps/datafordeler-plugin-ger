package dk.magenta.datafordeler.ger.data.responsible;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.magenta.datafordeler.core.database.IdentifiedEntity;
import dk.magenta.datafordeler.ger.GerPlugin;
import dk.magenta.datafordeler.ger.data.GerEntity;
import dk.magenta.datafordeler.ger.data.RawData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = GerPlugin.DEBUG_TABLE_PREFIX + ResponsibleEntity.TABLE_NAME, indexes = {
        @Index(
                name = GerPlugin.DEBUG_TABLE_PREFIX + ResponsibleEntity.TABLE_NAME + ResponsibleEntity.DB_FIELD_CODE,
                columnList = ResponsibleEntity.DB_FIELD_CODE
        ),
})
public class ResponsibleEntity extends GerEntity implements IdentifiedEntity {

    public static final String TABLE_NAME = "ger_participant";

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
    public static final String schema = "Participant";


    public ResponsibleEntity() {
    }

    public ResponsibleEntity(RawData record) {
        this.setGer(record.getInt("GERNR"));
    }

    public static UUID generateUUID(int gerNr) {
        String uuidInput = "responsible:"+gerNr;
        return UUID.nameUUIDFromBytes(uuidInput.getBytes());
    }





    public static final String DB_FIELD_OPERATION_FORM_CODE = "operationFormCode";
    public static final String IO_FIELD_OPERATION_FORM_CODE = "driftsformKode";
    @Column(name = DB_FIELD_OPERATION_FORM_CODE)
    @JsonProperty(value = IO_FIELD_OPERATION_FORM_CODE)
    private Integer operationFormCode;

    public Integer getOperationFormCode() {
        return this.operationFormCode;
    }

    public void setOperationFormCode(Integer operationFormCode) {
        this.operationFormCode = operationFormCode;
    }



    public static final String DB_FIELD_OPERATION_FORM_TEXT = "operationFormText";
    public static final String IO_FIELD_OPERATION_FORM_TEXT = "driftsformTekst";
    @Column(name = DB_FIELD_OPERATION_FORM_TEXT)
    @JsonProperty(value = IO_FIELD_OPERATION_FORM_TEXT)
    private String operationFormText;

    public String getOperationFormText() {
        return this.operationFormText;
    }

    public void setOperationFormText(String operationFormText) {
        this.operationFormText = operationFormText;
    }



    public static final String DB_FIELD_JE_END_DATE = "jeEndDate";
    public static final String IO_FIELD_JE_END_DATE = "jeSlutDato";
    @Column(name = DB_FIELD_JE_END_DATE)
    @JsonProperty(value = IO_FIELD_JE_END_DATE)
    private LocalDate jeEndDate;

    public LocalDate getJeEndDate() {
        return this.jeEndDate;
    }

    public void setJeEndDate(LocalDate jeEndDate) {
        this.jeEndDate = jeEndDate;
    }


    public static final String DB_FIELD_MEMO = "relationMemo";
    public static final String IO_FIELD_MEMO = "relationsnotat";
    @Column(name = DB_FIELD_MEMO, length = 5000)
    @JsonProperty(value = IO_FIELD_MEMO)
    private String relationMemo;

    public String getRelationMemo() {
        return this.relationMemo;
    }

    public void setRelationMemo(String relationMemo) {
        this.relationMemo = relationMemo;
    }




    public static final String DB_FIELD_RELATION_START_DATE = "relationStartDate";
    public static final String IO_FIELD_RELATION_START_DATE = "relationStartDato";
    @Column(name = DB_FIELD_RELATION_START_DATE)
    @JsonProperty(value = IO_FIELD_RELATION_START_DATE)
    private LocalDate relationStartDate;

    public LocalDate getRelationStartDate() {
        return this.relationStartDate;
    }

    public void setRelationStartDate(LocalDate relationStartDate) {
        this.relationStartDate = relationStartDate;
    }

    public static final String DB_FIELD_RELATION_END_DATE = "relationEndDate";
    public static final String IO_FIELD_RELATION_END_DATE = "relationSlutDato";
    @Column(name = DB_FIELD_RELATION_END_DATE)
    @JsonProperty(value = IO_FIELD_RELATION_END_DATE)
    private LocalDate relationEndDate;

    public LocalDate getRelationEndDate() {
        return this.relationEndDate;
    }

    public void setRelationEndDate(LocalDate relationEndDate) {
        this.relationEndDate = relationEndDate;
    }





    public static final String DB_FIELD_RELATION_CREATE_DATE = "relationCreateDate";
    public static final String IO_FIELD_RELATION_CREATE_DATE = "relationOpretDato";
    @Column(name = DB_FIELD_RELATION_CREATE_DATE)
    @JsonProperty(value = IO_FIELD_RELATION_CREATE_DATE)
    private LocalDate relationCreateDate;


    public LocalDate getRelationCreateDate() {
        return this.relationCreateDate;
    }

    public void setRelationCreateDate(LocalDate relationCreateDate) {
        this.relationCreateDate = relationCreateDate;
    }



    public static final String DB_FIELD_RELATION_UPDATE_DATE = "relationUpdateDate";
    public static final String IO_FIELD_RELATION_UPDATE_DATE = "relationOpdateretDato";
    @Column(name = DB_FIELD_RELATION_UPDATE_DATE)
    @JsonProperty(value = IO_FIELD_RELATION_UPDATE_DATE)
    private LocalDate relationUpdateDate;

    public LocalDate getRelationUpdateDate() {
        return this.relationUpdateDate;
    }

    public void setRelationUpdateDate(LocalDate relationUpdateDate) {
        this.relationUpdateDate = relationUpdateDate;
    }




    public static final String DB_FIELD_CVR_PARTICIPANT_GUID = "cvrParticipantGuid";
    public static final String IO_FIELD_CVR_PARTICIPANT_GUID = "cvrDeltagerGuid";
    @Column(name = DB_FIELD_CVR_PARTICIPANT_GUID)
    @JsonProperty(value = IO_FIELD_CVR_PARTICIPANT_GUID)
    private UUID cvrParticipantGuid;

    public UUID getCvrParticipantGuid() {
        return this.cvrParticipantGuid;
    }

    public void setCvrParticipantGuid(UUID cvrParticipantGuid) {
        this.cvrParticipantGuid = cvrParticipantGuid;
    }



    public static final String DB_FIELD_UNIT_NUMBER = "unitNumber";
    public static final String IO_FIELD_UNIT_NUMBER = "enhedsNummer";
    @Column(name = DB_FIELD_UNIT_NUMBER)
    @JsonProperty(value = IO_FIELD_UNIT_NUMBER)
    private Integer unitNumber;

    public Integer getUnitNumber() {
        return this.unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }



    public static final String DB_FIELD_UNIT_TYPE = "unitType";
    public static final String IO_FIELD_UNIT_TYPE = "enhedsType";
    @Column(name = DB_FIELD_UNIT_TYPE)
    @JsonProperty(value = IO_FIELD_UNIT_TYPE)
    private String unitType;

    public String getUnitType() {
        return this.unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }



    public static final String DB_FIELD_NAME = "name";
    public static final String IO_FIELD_NAME = "navn";
    @Column(name = DB_FIELD_NAME)
    @JsonProperty(value = IO_FIELD_NAME)
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public static final String DB_FIELD_CPR = "cprNumber";
    public static final String IO_FIELD_CPR = "cprNumber";
    @Column(name = DB_FIELD_CPR)
    @JsonProperty(value = IO_FIELD_CPR)
    private Integer cprNumber;

    public Integer getCprNumber() {
        return this.cprNumber;
    }

    public void setCprNumber(Integer cprNumber) {
        this.cprNumber = cprNumber;
    }



    public static final String DB_FIELD_CVR = "cvrNumber";
    public static final String IO_FIELD_CVR = "cvrNumber";
    @Column(name = DB_FIELD_CVR)
    @JsonProperty(value = IO_FIELD_CVR)
    private Integer cvrNumber;

    public Integer getCvrNumber() {
        return this.cvrNumber;
    }

    public void setCvrNumber(Integer cvrNumber) {
        this.cvrNumber = cvrNumber;
    }



    public static final String DB_FIELD_LAST_UPDATED = "lastUpdated";
    public static final String IO_FIELD_LAST_UPDATED = "sidstOpdateret";
    @Column(name = DB_FIELD_LAST_UPDATED)
    @JsonProperty(value = IO_FIELD_LAST_UPDATED)
    private LocalDate lastUpdated;

    public LocalDate getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
