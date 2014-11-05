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
package edu.utah.further.ds.omop.model.v2.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import edu.utah.further.core.api.data.PersistentEntity;

/**
 * The persistent class for the PROCEDURE_OCCURENCE database table.
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2013 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 * 
 * @author N. Dustin Schultz {@code <dustin.schultz@utah.edu>}
 * @version Apr 24, 2013
 */
@Entity
@Table(name = "PROCEDURE_OCCURRENCE")
@XmlRootElement(name = "ProcedureOccurrence")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcedureOccurrence implements PersistentEntity<Long>
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROCEDURE_OCCURRENCE_ID")
	private Long procedureOccurrenceId;

	@Column(name = "PROCEDURE_CONCEPT_ID")
	private BigDecimal procedureConceptId;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROCEDURE_DATE")
	private Date procedureDate;

	@Column(name = "SOURCE_PROCEDURE_CODE")
	private String sourceProcedureCode;

	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	// bi-directional many-to-one association to ProcOccurrenceRef
	@ManyToOne
	@JoinColumn(name = "PROCEDURE_OCCURRENCE_TYPE")
	private ProcedureOccurrenceRef procOccurrenceRef;

	public ProcedureOccurrence()
	{
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.utah.further.core.api.discrete.HasIdentifier#getId()
	 */
	@Override
	public Long getId()
	{
		return this.procedureOccurrenceId;
	}

	public void setId(final Long procedureOccurrenceId)
	{
		this.procedureOccurrenceId = procedureOccurrenceId;
	}

	public BigDecimal getProcedureConceptId()
	{
		return this.procedureConceptId;
	}

	public void setProcedureConceptId(final BigDecimal procedureConceptId)
	{
		this.procedureConceptId = procedureConceptId;
	}

	public Date getProcedureDate()
	{
		return this.procedureDate;
	}

	public void setProcedureDate(final Date procedureDate)
	{
		this.procedureDate = procedureDate;
	}

	public String getSourceProcedureCode()
	{
		return this.sourceProcedureCode;
	}

	public void setSourceProcedureCode(final String sourceProcedureCode)
	{
		this.sourceProcedureCode = sourceProcedureCode;
	}

	public Person getPerson()
	{
		return this.person;
	}

	public void setPerson(final Person person)
	{
		this.person = person;
	}

	public ProcedureOccurrenceRef getProcOccurrenceRef()
	{
		return this.procOccurrenceRef;
	}

	public void setProcOccurrenceRef(final ProcedureOccurrenceRef procOccurrenceRef)
	{
		this.procOccurrenceRef = procOccurrenceRef;
	}

}