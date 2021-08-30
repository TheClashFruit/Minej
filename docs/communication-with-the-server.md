# Communication with the server

Accessing communication class(es):
```js
// MinejJavaInterface
let MinejJavaInterface = Java.type('xyz.theclashfruit.minej.MinejJavaInterface');

// JavaPlugin
let JavaPlugin = Java.type('org.bukkit.plugin.java.JavaPlugin');

// More will be added soon.
```

Sending a message to the console:
```js
MinejJavaInterface.sendConsole('hello from js');
```

Registering a command:
```js
MinejJavaInterface.registerCommand('commandName', 'commandDescription', 'command.permission', (commandSender, s, strings) => {
  commandSender.sendMessage("you ran a command!");
});
```