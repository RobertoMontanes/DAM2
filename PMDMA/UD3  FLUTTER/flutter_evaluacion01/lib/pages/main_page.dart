import 'package:flutter/material.dart';
import 'package:flutter_evaluacion01/shared/country_currency_box.dart';
import 'package:flutter_evaluacion01/shared/rectangle_buton.dart';

class MainPage extends StatelessWidget {
  const MainPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: const Color.fromARGB(210, 228, 243, 255),
      child: Column(
        children: [
          Expanded(
            flex: 6,
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Column(
                children: [
                  Expanded(
                    flex: 3,
                    child: Row(
                      children: [
                        Expanded(
                          flex: 1,
                          child: ElevatedButton(
                            onPressed: () => {},
                            style: ElevatedButton.styleFrom(
                              shape: const CircleBorder(),
                              backgroundColor: Colors.white,
                              shadowColor: Colors.transparent,
                              padding: EdgeInsets.zero,
                            ),
                            child: Icon(
                              Icons.close,
                              size: 20,
                              color: Colors.black,
                            ),
                          ),
                        ),
                        Expanded(
                          flex: 7,
                          child: Padding(
                            padding: const EdgeInsets.fromLTRB(0, 30.0, 0, 0),
                            child: Column(
                              children: [
                                Text(
                                  "Between Accounts",
                                  style: TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.w500,
                                  ),
                                ),
                                Text(
                                  "No commision",
                                  style: TextStyle(
                                    fontSize: 20,
                                    color: Colors.grey,
                                    fontWeight: FontWeight.w500,
                                  ),
                                ),
                                SizedBox(
                                  height: 10,
                                ),
                                Container(
                                  padding: EdgeInsets.all(5),
                                  decoration: BoxDecoration(
                                    color: const Color.fromARGB(255, 50, 50, 50),
                                    borderRadius: BorderRadius.circular(100),
                                  ),
                                  child: SizedBox(
                                    height: 20,
                                    width: 170,
                                    child: Center(
                                      child: Text(
                                        "1USD = 7,2493 CNY",
                                        style: TextStyle(
                                          color: Colors.white,
                                          fontWeight: FontWeight.bold,
                                          fontSize: 15,
                                        ),
                                      ),
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ),
                        Expanded(flex: 1, child: Text("")),
                      ],
                    ),
                  ),
                  Expanded(
                    flex: 7,
                      child: Padding(
                      padding: const EdgeInsets.fromLTRB(0, 15, 0, 15),
                      child: Stack(
                        alignment: Alignment.center,
                        children: [
                        Column(
                          children: [
                          Expanded(
                            flex: 5,
                            child: CountryCurrencyBox(upperBalance: "140.00",lowerBalance: "150.56",currency: "USD", symbol: "¥",),
                          ),
                          Padding(padding: EdgeInsetsGeometry.all(5)),
                          Expanded(
                            flex: 5,
                            child: CountryCurrencyBox(upperBalance: "1014.902",lowerBalance: "246.63",currency: "CNY", imageAsset: "flag_china.png",symbol: "\$",),
                          ),
                          ],
                        ),
                        Container(
                          width: 50,
                          height: 50,
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(100),
                            color: const Color.fromARGB(255, 50, 50, 50),
                          ),
                          child: Icon(Icons.swap_horiz, size: 35, color: Colors.white,)
                          )
                        ],
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          Expanded(
            flex: 5,
            child: Padding(
              padding: EdgeInsets.fromLTRB(0,10,0,5),
              child: Column(
                spacing: 10,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      RectangleButon(content: "1"),
                      RectangleButon(content: "2"),
                      RectangleButon(content: "3"),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      RectangleButon(content: "4"),
                      RectangleButon(content: "5"),
                      RectangleButon(content: "6"),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      RectangleButon(content: "7"),
                      RectangleButon(content: "8"),
                      RectangleButon(content: "9"),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      RectangleButon(
                        content: ".",
                        backgroundColor: Colors.transparent,
                      ),
                      RectangleButon(content: "0"),
                      SizedBox(height: 80, width: 125),
                    ],
                  ),
                ],
              ),
            ),
          ),
          Expanded(
            flex: 1, 
            child: Container(
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(50),
                color: const Color.fromARGB(255, 50, 50, 50),
              ),
              width: 400,
              height: double.infinity,
              child: Center(child: Text("Continue", style: TextStyle(color: Colors.white, fontSize: 20, fontWeight: FontWeight.w500),)),
            )
          ),
          SizedBox(
            height: 20,
          )
        ],
      ),
    );
  }
}
