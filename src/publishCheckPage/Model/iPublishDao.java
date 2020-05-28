package publishCheckPage.Model;

import java.sql.SQLException;
import java.text.ParseException;

public interface iPublishDao {

	PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException;

}