const fs = require('fs');
const yargs = require('yargs');
const shell = require('shelljs');
const _ = require('lodash');


const ignoredFiles = ["as2client.jar", "tj.exe", ".vscode/"];


const pathConfig = {
    demand: true,
    describe: 'Path to directory',
    alias: 'p'
}

const argv = yargs
    .command('addDir', 'Adds a directory and creates a .gitignore file in it', {
        path: pathConfig
    })
    .command('rm', 'Removes the file from specified file path', {
        path: pathConfig
    })
    .help().argv;

var command = argv._[0];

var createPaths = (ignored, path) => {
    var holder = '';
    for (var i = 0; i < ignored.length; i++) {

        var currentFile = ignored[i];

        holder += "\n" + path + currentFile + "\n";
    }
    console.log("returning holder: " + holder);
    return holder;
}

var addToGit = path => {
    return new Promise((resolve, reject) => {

        const gitIgnore = './.gitignore';

        // (!fs.exists(gitIgnore))
        //     fs.writeFile(gitIgnore, createPaths(ignoredFiles, path), err => console.log(err));


        var currentConfig = fs.readFileSync(gitIgnore);
        currentConfig += createPaths(ignoredFiles, path);
        fs.writeFileSync(gitIgnore, currentConfig, err => console.log(err));


        if (shell.exec('git add ' + argv.path).code !== 0) {
            reject('Error adding file to git repository');
        }
        else {
            resolve('Added file to git repository');
        }

    });
}

if (command == 'addDir') {
    console.log('Adding directory: ', argv.path);

    addToGit(argv.path).then(message => console.log(message)).catch(err => console.log(err));


}


