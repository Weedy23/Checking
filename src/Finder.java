import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;

public class Finder {
    private String[] strings;
    private double Best;
    SimilarityStrategy strategy = new JaroWinklerStrategy();
    StringSimilarityService similarity = new StringSimilarityServiceImpl(strategy);
    public String[] findAll(String[] strings) {
        this.strings = strings;
        String[] res = new String[5];

        res[0] = findName();
        res[1] = findRegNr();
        res[2] = findDate();
        res[3] = findSum();
        res[4] = findDokNr();

        int err = 0;
        for (int i = 0; i < 5; i++) {
            if (res[i] == null) {
                res[i] = "Error: Not Found!";
                err++;
            }
        }

        if (err == 5) {
            return new String[] {"Error: Your photo is in bed quality or does not contains any text!"};
        }
        return res;
    }

    private String findName() {
        String target = "SIA";
        int id = similarityCheck(target);
        /*
        String[] temp = strings[id].split(",");
        if (temp.length > 1) {
            int tempId = -1;
            double best = -1.0;
            for (int i = 0; i < temp.length; i++) {
                double score = similarity.score(temp[i], target);
                if (score > best) {
                    tempId = i;
                    best = score;
                }
            }
            return strings[tempId];
        }
         */
        if (strings[id].contains("SIA")) {
            return strings[id];
        } else {
            return null;
        }
    }

    private String findRegNr() {
        String[] targets = {"PVN maksataja numurs", "PVN", "REG.NR."};
        String[] resultsStrings = new String[3];
        double[] resultsS = new double[3];
        for (int j = 0; j < 3; j++) {
            int id = similarityCheck(targets[j]);
            /*
            String[] temp = strings[id].split(":");
            if (temp.length == 1) {
                temp = strings[id].split(" ");
            }
            if (temp.length > 1) {
                int tempId = -1;
                double best = -1.0;
                for (int i = 0; i < temp.length; i++) {
                    double score = similarity.score(temp[i], targets[j]);
                    if (score > best) {
                        tempId = i;
                        best = score;
                    }
                }
                resultsStrings[j] = temp[tempId + 1];
                resultsS[j] = best;
            }
             */
            if (strings[id].contains("PVN") || strings[id].contains("REG")) {
                resultsStrings[j] = strings[id];
                resultsS[j] = Best;
            }

        }
        if (resultsS[0] > resultsS[1]) {
            if (resultsS[0] > resultsS[2]) {
                return resultsStrings[0];
            } else {
                return resultsStrings[2];
            }
        } else if (resultsS[1] > resultsS[2]) {
            return resultsStrings[1];
        } else {
            return resultsStrings[2];
        }
    }

    private String findDate() {
        String[] targets = {"Datums: 44/04/4444", "44.04.4444", "44-04-4444"};
        String[] resultsStrings = new String[3];
        double[] resultsS = new double[3];
        for (int j = 0; j < 3; j++) {
            int id = similarityCheck(targets[j]);
            /*
            String[] temp = strings[id].split(" ");
            if (temp.length > 1) {
                int tempId = -1;
                double best = -1.0;
                for (int i = 0; i < temp.length; i++) {
                    double score = similarity.score(temp[i], targets[j]);
                    if (score > best) {
                        tempId = i;
                        best = score;
                    }
                }
                resultsStrings[j] = temp[tempId];
                resultsS[j] = best;
            }
             */
            if (strings[id].contains("/") || strings[id].contains(".") || strings[id].contains("-")) {
                resultsStrings[j] = strings[id];
                resultsS[j] = Best;
            }
        }

        if (resultsS[0] > resultsS[1]) {
            if (resultsS[0] > resultsS[2]) {
                return resultsStrings[0];
            } else {
                return resultsStrings[2];
            }
        } else if (resultsS[1] > resultsS[2]) {
            return resultsStrings[1];
        } else {
            return resultsStrings[2];
        }
    }

    private String findSum() {
        String[] targets = {"Samaksai EUR", "KOPA EUR", "SUMMA :"};
        String[] resultsStrings = new String[3];
        double[] resultsS = new double[3];
        for (int j = 0; j < 3; j++) {
            int id = similarityCheck(targets[j]);
            /*
            //String[] temp = strings[id].split(" ");
            String[] temp = strings[id].split(" ");
            if (temp.length > 1) {
                int tempId = 0;
                double best = -1.0;
                for (int i = 0; i < temp.length; i++) {
                    double score = similarity.score(temp[i], targets[j]);
                    if (score > best) {
                        if (temp[i].contains(",") || temp[i].contains(".")) {
                            tempId = i;
                            best = score;
                        }
                    }
                }

                resultsStrings[j] = temp[tempId];
                resultsS[j] = best;
            }
             */
            if (strings[id].contains(",") || strings[id].contains(".")) {
                resultsStrings[j] = strings[id];
                resultsS[j] = Best;
            }
        }

        if (resultsS[0] > resultsS[1]) {
            if (resultsS[0] > resultsS[2]) {
                return resultsStrings[0];
            } else {
                return resultsStrings[2];
            }
        } else if (resultsS[1] > resultsS[2]) {
            return resultsStrings[1];
        } else {
            return resultsStrings[2];
        }
    }

    private String findDokNr() {
        String[] targets = {"Dok. Nr.: 444444444", "DOK.#444444444"};
        String[] resultsStrings = new String[2];
        double[] resultsS = new double[2];
        for (int j = 0; j < 2; j++) {
            int id = similarityCheck(targets[j]);
            /*
            String[] temp = strings[id].split("#");
            if (temp.length == 1) {
                temp = strings[id].split(" ");
            }
            if (temp.length > 1) {
                int tempId = -1;
                double best = -1.0;
                for (int i = 0; i < temp.length; i++) {
                    double score = similarity.score(temp[i], targets[j]);
                    if (score > best) {
                        tempId = i;
                        best = score;
                    }
                }
                resultsStrings[j] = temp[tempId + 1];
                resultsS[j] = best;
            }
             */

            if (strings[id].contains(":") || strings[id].contains("#")) {
                resultsStrings[j] = strings[id];
                resultsS[j] = Best;
            }
        }

        if (resultsS[0] > resultsS[1]) {
            return resultsStrings[0];
        } else {
            return resultsStrings[1];
        }
    }

    private int similarityCheck(String target) {
        Best = -1.0;
        int id = -1;
        for (int i = 0; i < strings.length; i++) {
            double score = similarity.score(strings[i], target);
            if (score > Best) {
                Best = score;
                id = i;
            }
        }
        return id;
    }
}
