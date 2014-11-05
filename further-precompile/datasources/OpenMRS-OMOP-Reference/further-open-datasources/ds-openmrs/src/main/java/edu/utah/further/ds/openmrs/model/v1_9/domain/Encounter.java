/**
 * Copyright (C) [2013] [The FURTHeR Project]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.utah.further.ds.openmrs.model.v1_9.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.utah.further.core.api.data.PersistentEntity;
import edu.utah.further.core.xml.jaxb.adapter.BooleanIntegerAdapter;

/**
 * The persistent class and data transfer object for the encounter database table.
 * 
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2012 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 * 
 * @author N. Dustin Schultz {@code <dustin.schultz@utah.edu>}
 * @version Sep 3, 2013
 */
@Table(name="encounter")
@Entity
@XmlRootElement(name = "Encounter")
@XmlAccessorType(XmlAccessType.FIELD)
public class Encounter implements PersistentEntity<Integer>
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "encounter_id")
	private Integer encounterId;

	@Column(name = "changed_by")
	private Long changedBy;

	private Long creator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_changed")
	private Date dateChanged;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_voided")
	private Date dateVoided;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "encounter_datetime")
	private Date encounterDatetime;

	@Column(name = "form_id")
	private Long formId;

	@Column(name = "location_id")
	private Long locationId;

	private String uuid;

	@Column(name = "visit_id")
	private Long visitId;

	@Column(name = "void_reason")
	private String voidReason;

	@XmlJavaTypeAdapter(BooleanIntegerAdapter.class)
	private Boolean voided;

	@Column(name = "voided_by")
	private Long voidedBy;

	// bi-directional many-to-one association to Patient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	@XmlTransient
	private Patient patient;

	// bi-directional many-to-one association to EncounterType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "encounter_type")
	@XmlTransient
	private EncounterType encounterType;

	// bi-directional many-to-one association to Observation
	@OneToMany(mappedBy = "encounter")
	@XmlTransient
	private List<Observation> observations;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "encounter")
	@XmlTransient
	private List<Order> orders;

	public Encounter()
	{
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.utah.further.core.api.discrete.HasIdentifier#getId()
	 */
	@Override
	public Integer getId()
	{
		return this.encounterId;
	}

	public void setId(final Integer encounterId)
	{
		this.encounterId = encounterId;
	}

	public Long getChangedBy()
	{
		return this.changedBy;
	}

	public void setChangedBy(final Long changedBy)
	{
		this.changedBy = changedBy;
	}

	public Long getCreator()
	{
		return this.creator;
	}

	public void setCreator(final Long creator)
	{
		this.creator = creator;
	}

	public Date getDateChanged()
	{
		return this.dateChanged;
	}

	public void setDateChanged(final Date dateChanged)
	{
		this.dateChanged = dateChanged;
	}

	public Date getDateCreated()
	{
		return this.dateCreated;
	}

	public void setDateCreated(final Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	public Date getDateVoided()
	{
		return this.dateVoided;
	}

	public void setDateVoided(final Date dateVoided)
	{
		this.dateVoided = dateVoided;
	}

	public Date getEncounterDatetime()
	{
		return this.encounterDatetime;
	}

	public void setEncounterDatetime(final Date encounterDatetime)
	{
		this.encounterDatetime = encounterDatetime;
	}

	public Long getFormId()
	{
		return this.formId;
	}

	public void setFormId(final Long formId)
	{
		this.formId = formId;
	}

	public Long getLocationId()
	{
		return this.locationId;
	}

	public void setLocationId(final Long locationId)
	{
		this.locationId = locationId;
	}

	public String getUuid()
	{
		return this.uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public Long getVisitId()
	{
		return this.visitId;
	}

	public void setVisitId(final Long visitId)
	{
		this.visitId = visitId;
	}

	public String getVoidReason()
	{
		return this.voidReason;
	}

	public void setVoidReason(final String voidReason)
	{
		this.voidReason = voidReason;
	}

	public Boolean getVoided()
	{
		return this.voided;
	}

	public void setVoided(final Boolean voided)
	{
		this.voided = voided;
	}

	public Long getVoidedBy()
	{
		return this.voidedBy;
	}

	public void setVoidedBy(final Long voidedBy)
	{
		this.voidedBy = voidedBy;
	}

	public Patient getPatient()
	{
		return this.patient;
	}

	public void setPatient(final Patient patient)
	{
		this.patient = patient;
	}

	public EncounterType getEncounterTypeBean()
	{
		return this.encounterType;
	}

	public void setEncounterTypeBean(final EncounterType encounterTypeBean)
	{
		this.encounterType = encounterTypeBean;
	}

	public List<Observation> getObs()
	{
		return this.observations;
	}

	public void setObs(final List<Observation> obs)
	{
		this.observations = obs;
	}

	public Observation addOb(final Observation ob)
	{
		getObs().add(ob);
		ob.setEncounter(this);

		return ob;
	}

	public Observation removeOb(final Observation ob)
	{
		getObs().remove(ob);
		ob.setEncounter(null);

		return ob;
	}

	public List<Order> getOrders()
	{
		return this.orders;
	}

	public void setOrders(final List<Order> orders)
	{
		this.orders = orders;
	}

	public Order addOrder(final Order order)
	{
		getOrders().add(order);
		order.setEncounter(this);

		return order;
	}

	public Order removeOrder(final Order order)
	{
		getOrders().remove(order);
		order.setEncounter(null);

		return order;
	}

}