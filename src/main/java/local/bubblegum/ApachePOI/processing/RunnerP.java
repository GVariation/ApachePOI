package local.bubblegum.ApachePOI.processing;

import local.bubblegum.ApachePOI.db.FBManage;
import local.bubblegum.ApachePOI.xl.XLProcessor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.sql.SQLException;

@Component
public class RunnerP {
    @EventListener(ApplicationReadyEvent.class)
    public void onReady () {
//        XLProcessor xlProcessor = new XLProcessor();
//        xlProcessor.readXLFile();

//      Коннект к scan.fdb и создаём таблицу Barcode_scan
//        FBManage fbManage = new FBManage();
//        Path path = Path.of("./src/main/resources/db/", "scan.fdb");
//        fbManage.connect(path);
//        String queryCreateDB = "EXECUTE BLOCK AS BEGIN\n" +
//                "if (not exists(select 1 from rdb$relations where rdb$relation_name = 'BARCODE_SCAN')) then\n" +
//                "execute statement 'create table BARCODE_SCAN ( id integer not null primary key, barcode varchar(50), file_name varchar(255), add_time timestamp default current_timestamp );';\n" +
//                "END\n";
//        try {
//            Boolean b = fbManage.execute(queryCreateDB, null);
//            int i = 0;
//            i++;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


}
