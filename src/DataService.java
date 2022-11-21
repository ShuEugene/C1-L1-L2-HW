import java.util.Arrays;

public class DataService {

    static boolean isCorrect(String value) {
        return value != null && !value.isBlank() && !value.isEmpty();
    }

    static boolean isCorrect(int value) {
        return value > 0;
    }

    static boolean isCorrect(float value) {
        return value > 0;
    }

    static boolean isCorrect(Object object) {
        return object != null;
    }

    static int getValidObjectsNumber(Object[] objects) {
        if (objects == null) return 0;
        int validRecordsNumber = objects.length;
        for (Object curObj :
                objects) {
            if (curObj == null) --validRecordsNumber;
        }
        return validRecordsNumber;
    }

    static int getValidObjectsNumber(Object[][] objects) {
        if (objects == null) return 0;
        int validRecordsNumber = objects.length;
        for (Object[] object : objects) {
            if (object[0] == null) {
                --validRecordsNumber;
            }
        }
        return validRecordsNumber;
    }

    static Flower[] getValidObjects(Flower[] objects) {
        int validObjectsNumber = getValidObjectsNumber(objects);
        if (validObjectsNumber <= 0) return null;
        Flower[] validObjects = new Flower[validObjectsNumber];
        int validObjectIndex = -1;
        for (Flower curObj : objects) {
            if (curObj != null) validObjects[++validObjectIndex] = curObj;
        }
        return validObjects;
    }

    static String[][] getValidObjects(String[][] objects) {
        int validObjectsNumber = getValidObjectsNumber(objects);
        if (validObjectsNumber <= 0) return null;
        String[][] validObjects = new String[validObjectsNumber][objects[0].length];
        int validObjectIndex = -1;
        for (String[] object : objects) {
            if (object[0] != null) {
                validObjects[++validObjectIndex] = Arrays.copyOf(object, object.length);
            }
        }
        return validObjects;
    }
}
