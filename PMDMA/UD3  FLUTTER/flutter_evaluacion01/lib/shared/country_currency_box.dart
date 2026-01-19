import 'package:flutter/material.dart';

class CountryCurrencyBox extends StatelessWidget {
  const CountryCurrencyBox(
    {
      super.key,
      required this.upperBalance,
      required this.lowerBalance,
      required this.currency,
      required this.symbol,
      this.imageAsset = "flag_usa.png",
      }
      );

  final String upperBalance;
  final String lowerBalance;
  final String currency;
  final String symbol;
  final String imageAsset;

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(40),
      ),
      child: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Column(
                crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(upperBalance, style: TextStyle(color: Colors.black, fontWeight: FontWeight.w600, fontSize: 35),),
                Text("Balance: $symbol$lowerBalance", style: TextStyle(color: const Color.fromARGB(255, 90, 90, 90), fontWeight: FontWeight.w400, fontSize: 15),)
              ],
            ),
            Container(
              height: 60,
              decoration: BoxDecoration(
                border: BoxBorder.all(
                  color: const Color.fromARGB(255, 220, 220, 220),
                ),
                borderRadius: BorderRadius.circular(10)
              ),
              padding: EdgeInsets.all(10),
              child: Row(
                children: [
                  Container(
                    height: 30,
                    width: 30,
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(100)
                    ),
                    child: Image.asset("assets/images/$imageAsset"),
                  ),
                  SizedBox(width: 10),
                  Text(currency),
                  SizedBox(width: 20),
                  Icon(Icons.keyboard_arrow_down)
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}