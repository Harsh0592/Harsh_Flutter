import 'package:flutter/material.dart';

class Third_Sceen extends StatelessWidget {
  final String name;
   Third_Sceen({super.key,required this.name});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Container(
        child: Column(
          children: [
            Text("${name}",style: TextStyle(
              fontSize: 32,fontWeight: FontWeight.bold
            ),),
            SizedBox(
              height: 20,
            ),
            Container(
              width: double.maxFinite,
              child: Image(image: NetworkImage("https://harshdalsaniya.000webhostapp.com/Travel_Assesment/images/download%20(3).jpeg"),fit: BoxFit.cover,)),
            SizedBox(
              height: 20,
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Container(
                child: Text("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",style: TextStyle(fontSize: 24),)),
            )
          ],
        ),
      ),
    );
  }
}