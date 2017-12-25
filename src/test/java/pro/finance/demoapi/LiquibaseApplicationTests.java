package pro.finance.demoapi;

import java.net.ConnectException;

import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.core.NestedCheckedException;

import static org.assertj.core.api.Assertions.assertThat;

public class LiquibaseApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() throws Exception {
		try {
			DemoapiApplication.main(new String[] { "--server.port=0" });
		}
		catch (IllegalStateException ex) {
			if (serverNotRunning(ex)) {
				return;
			}
		}
		String output = this.outputCapture.toString();
		assertThat(output).contains("Successfully acquired change log lock")
			.contains("Creating database history "
				+ "table with name: PUBLIC.DATABASECHANGELOG")
		.contains("Reading from PUBLIC.DATABASECHANGELOG")
			.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/changeLog-22-12-2017.xml::systemAccountTable::svasnev: Table system_account created")
				.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/changeLog-22-12-2017.xml::systemAccountTable::svasnev: ChangeSet classpath:db/changelog/changeLog-22-12-2017.xml::systemAccountTable::svasnev ran successfully")
					.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/changeLog-22-12-2017.xml::walletsTable::svasnev: Table wallet created")
						.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/changeLog-22-12-2017.xml::walletsTable::svasnev: Foreign key constraint added to wallet (system_account_id)")
							.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/changeLog-22-12-2017.xml::walletsTable::svasnev: ChangeSet classpath:db/changelog/changeLog-22-12-2017.xml::walletsTable::svasnev ran successfully")
								.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/changeLog-22-12-2017.xml::cardsTable::svasnev: Table card created")
									.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/changeLog-22-12-2017.xml::cardsTable::svasnev: Foreign key constraint added to card (system_account_id)")
										.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/changeLog-22-12-2017.xml::cardsTable::svasnev: ChangeSet classpath:db/changelog/changeLog-22-12-2017.xml::cardsTable::svasnev ran successfully")
											.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/test-data.xml::test-data::svasnev: Custom SQL executed")
												.contains("classpath:db/changelog/db.changelog-master.xml: classpath:db/changelog/test-data.xml::test-data::svasnev: ChangeSet classpath:db/changelog/test-data.xml::test-data::svasnev ran successfully")
													.contains("Successfully released change log lock");
	}

	@SuppressWarnings("serial")
	private boolean serverNotRunning(IllegalStateException ex) {
		NestedCheckedException nested = new NestedCheckedException("failed", ex) {
		};
		if (nested.contains(ConnectException.class)) {
			Throwable root = nested.getRootCause();
			if (root.getMessage().contains("Connection refused")) {
				return true;
			}
		}
		return false;
	}
}
