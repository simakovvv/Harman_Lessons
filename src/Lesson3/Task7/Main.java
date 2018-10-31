package Lesson3.Task7;

public class Main {
    //write a network server program. The program is a simple file server that makes a collection of files
    // available for transmission to clients. When the server starts up,  it needs to know the name of the
    // directory that contains the collection of files. This information can be provided as a command-line
    // argument. You can assume that the directory contains only regular files(that is, it does not contain
    // any sub-directories). You can also assume that all the files are text files. When a client connects
    // to the server, the server first reads a one-line command from the client. The command can be the
    // string "index". In this case, the server responds by sending a list of names of all the files that
    // are available on the server. Or the command can be of the form "get <file>", where<file> is a file
    // name. The server checks whether the requested file actually exists. If so, it first sends the word
    // "ok" as a message to the client. Then it sends the contents of the file and closes the connection.
    // Otherwise, it sends the word "error" to the client and closes the connection
}
