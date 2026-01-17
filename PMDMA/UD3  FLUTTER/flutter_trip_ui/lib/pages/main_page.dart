import 'package:flutter/material.dart';
import 'package:flutter_trip_ui/components/destination_card.dart';

class MainPage extends StatelessWidget {
  const MainPage({super.key});

  @override
  Widget build(BuildContext context) {

    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Column(
        children: [
          Spacer(),
          Expanded(flex: 1, child: Text("HELLO Y PROFILE")),
          Expanded(flex: 2, child: Text("BARRA BUSQUEDA")),
          Expanded(flex: 2, child: Text("NEXT TRIP")),
          Expanded(
            flex: 3,
            child: ListView(
              scrollDirection: Axis.horizontal,
              children: [
                DestinationCard(),
                DestinationCard(),
                DestinationCard(),
              ]
            ),
          ),
          Spacer()
        ],
      ),
    );
  }
}
