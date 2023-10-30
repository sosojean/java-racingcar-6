package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameFunction {

    List<Car> makingCar(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    List<Boolean> randomGo(List<Car> carList) {
        int numberOfCar = carList.size();
        List<Boolean> carCanGo = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            carCanGo.add(number >= 4);
        }
        return carCanGo;
    }

    void applyScore(List<Car> carList, List<Boolean> carCanGo) {
        for (int j = 0; j < carList.size(); j++) {
            Boolean go = carCanGo.get(j);
            Car car = carList.get(j);
            if (go) {
                car.gainScore();
            }
        }
    }


    void repeatGame(int turn, List<Car> carList) {
        Print print = new Print();
        List<Boolean> carCanGo = randomGo(carList);

        for (int i = 0; i < turn; i++) {
            applyScore(carList, carCanGo);
            print.Score(carList);
        }

    }


}
