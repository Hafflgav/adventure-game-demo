/*
 * Copyright WKS Power Limited under one or more contributor license agreements. 
 * See the LICENSE file distributed with this work for additional information regarding 
 * copyright ownership. WKS Power licenses this file to you under the 
 * GNU AFFERO GENERAL PUBLIC LICENSE v3.0; you may not use this file except in compliance with 
 * the License. You may obtain a copy of the License at
 *
 *     https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.victorfranca.duedate.api.server;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorfranca.duedate.calendar.datasource.CalendarDataSource;
import com.victorfranca.duedate.calendar.datasource.CalendarDataSourceException;

@RestController
class HeyDueDateCalendarsController {

	// TODO adapt to noums and verbs REST structure

	@Resource(name = "calendarDataSource")
	private CalendarDataSource calendarDataSource;

	@GetMapping(value = "/calendar")
	public List<String> getDueDateWithLog() {

		try {
			return calendarDataSource.getCalendarsNames();
		} catch (CalendarDataSourceException e) {
			throw new RuntimeException("Internal Error", e);
		}

	}

}