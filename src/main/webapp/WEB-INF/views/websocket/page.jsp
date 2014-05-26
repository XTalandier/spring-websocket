<html>
<head>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/socket.io/0.9.16/socket.io.min.js" charset="utf-8"></script>
</head>
<body>
	<h1>Websocket Page :)</h1>
    <button onclick="sendMessage()">sendMessage()</button>

	<script type="text/javascript">

           var socket = io.connect('http://localhost:3030', {
             'reconnection delay' : 2000,
             'force new connection' : true
           });

           socket.on('message', function(data) {
        	   log('I get a message :')
        	   log(data);
           });

           socket.on('evt1', function(data) {
        	   log('I get an evt1 :')
        	   	log(data);
           });

           socket.on('connect', function() {
                // connection established, now we can send an objects


                // send json-object to server
                // '@class' property should be defined and should 
                // equals to full class name.
                //socket.json.send(obj);



                // send event-object to server
                // '@class' property is NOT necessary in this case
				sendMessage();
       });
           
           
           function sendMessage(){
               var event = {
                   	ts: new Date(),
                   	text: "Hello"
                   };
                   socket.emit('hello', event);
           }

           function log(data){
        	   $('output').value = '[' + (new Date()) + ']' + data + "\n" + $('output').value;
           }
           function $(id){
        	   return document.getElementById(id);
           }
           </script>
           
           <textarea id="output" style="width: 100%; height: 400px" readonly="readonly"></textarea>
</body>
</html>

