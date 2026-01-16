import 'package:flutter/material.dart';

class MainPage extends StatelessWidget {
  const MainPage({super.key});

  @override
  Widget build(BuildContext context) {

    const paddingSides = 20.0;

    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Column(
        children: [
          Expanded(
            flex: 1,
            child: Text("HELLO Y PROFILE"),
          ),
          Expanded(
            flex: 2,
            child: Text("BARRA BUSQUEDA"),
          ),
          Expanded(
            flex: 2,
            child: Text("NEXT TRIP"),
          ),
          Expanded(
            flex: 3,
            child: Padding(
              padding: const EdgeInsets.fromLTRB(paddingSides, 0.0, paddingSides, 0.0),
              child: Container(
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(20),
                  image: DecorationImage(image: NetworkImage("https://res.cloudinary.com/worldpackers/image/upload/c_fill,f_auto,q_auto,w_1024/v1/guides/article_cover/dtceexjjoji0w1ikkp2k?_a=BACAGSGT"))
                ),
                child: Column(
                  children: [
                    Expanded(
                      flex: 1,
                      child: Text("LIKE"), 
                    ),
                    Expanded(
                      flex: 1,
                      child: Text("empty")
                      ),
                    Expanded(
                      flex: 1,
                      child:
                        Column(
                          children: [
                            Text("Brazil"),
                            Text("Rio de janeiro"),
                            Row(
                              children: [
                                Text("Stars"),
                                Text("143 reviews")
                              ],
                            )
                          ],
                        ) 
                    )
                  ],
                ),
              ),
            )
          ),

        ],
      ),
    );
  }
}