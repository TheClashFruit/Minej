# Communication with the server

Accessing communication class(es):
```js
// MinejJavaInterface
let MinejJavaInterface = Java.type('xyz.theclashfruit.minej.MinejJavaInterface');

// Bukkit Classes
let Bukkit = {
  JavaPlugin: Java.type('org.bukkit.plugin.java.JavaPlugin'),
  Command: Java.type('org.bukkit.command.Command'),
  CommandSender: Java.type('org.bukkit.command.CommandSender')
}

// More will be added soon.
```

Sending a message to the console:
```js
MinejJavaInterface.sendConsole('hello from js');
```

Registering a command:
```js
const myCommand = {
  name: 'commandName', 
  description: 'commandDescription',
  permission: 'command.permission',
  aliases: [ 'commandAlias' ],
  execute: (commandSender, s, strings) => {
    commandSender.sendMessage("this is a pogger command!");
  }
}

MinejJavaInterface.registerCommand(myCommand);
```
