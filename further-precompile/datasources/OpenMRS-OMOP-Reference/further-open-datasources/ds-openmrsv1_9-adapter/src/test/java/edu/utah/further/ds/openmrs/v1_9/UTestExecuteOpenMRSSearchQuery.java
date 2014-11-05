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
package edu.utah.further.ds.openmrs.v1_9;

import static org.junit.Assert.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.xml.bind.JAXBException;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.utah.further.core.api.xml.XmlService;
import edu.utah.further.core.data.hibernate.adapter.CriteriaType;
import edu.utah.further.core.data.hibernate.query.QueryBuilderHibernateImpl;
import edu.utah.further.core.query.domain.SearchQuery;
import edu.utah.further.core.query.domain.SearchQueryTo;
import edu.utah.further.core.xml.jaxb.XmlServiceImpl;
import edu.utah.further.fqe.impl.domain.SearchQueryEntity;

/**
 * Quick test class that can be used to query an OpenMRS 1.9 data model with a SearchQuery
 * xml.
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
 * @version Oct 25, 2013
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "/ds-openmrsv1_9-context.xml" })
public class UTestExecuteOpenMRSSearchQuery
{
	// ========================= CONSTANTS =================================

	/**
	 * A logger that helps identify this class' printouts.
	 */
	private static final Logger log = getLogger(MethodHandles.lookup().lookupClass());

	// ========================= DEPENDENCIES =================================

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Execute an OpenMRS query against v1.9 model.
	 * 
	 * @throws IOException
	 * @throws JAXBException
	 */
	@Test
	@Transactional
	public void execute() throws JAXBException, IOException
	{
		final XmlService xmlService = new XmlServiceImpl();
		final SearchQuery query = xmlService.unmarshalResource("test-query.xml",
				SearchQueryTo.class);

		final int resultSize = QueryBuilderHibernateImpl
				.convert(CriteriaType.CRITERIA,
						"edu.utah.further.ds.openmrs.model.v1_9.domain", sessionFactory,
						SearchQueryEntity.newCopy(query))
				.list()
				.size();

		log.info("Results returned: " + resultSize);

		assertTrue(resultSize >= 0);
	}
}
