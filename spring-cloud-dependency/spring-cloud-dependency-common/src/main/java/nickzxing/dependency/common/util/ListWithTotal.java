package nickzxing.dependency.common.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ListWithTotal<T> {
	long recordNum = 0;
	List<T> records = new ArrayList<>();
}
