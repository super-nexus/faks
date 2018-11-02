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
        //USE AT YOUR OWN RISK
        path: pathConfig
    })
    .command('acp', "Adds commits and pushes the directory to origin master", {
        path: pathConfig,
        message: {
            demand: true,
            alias: 'm',
            describe: "Message for the git commit"
        }
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

var addToGit = (path, addIgnore) => {
    return new Promise((resolve, reject) => {

        const gitIgnore = './.gitignore';

        // (!fs.exists(gitIgnore))
        //     fs.writeFile(gitIgnore, createPaths(ignoredFiles, path), err => console.log(err));

        if (addIgnore) {
            var currentConfig = fs.readFileSync(gitIgnore);
            currentConfig += createPaths(ignoredFiles, path);
            fs.writeFileSync(gitIgnore, currentConfig, err => console.log(err));
        }

        if (shell.exec('git add ' + argv.path).code !== 0) {
            reject('Error adding file to git repository');
        }
        else {
            resolve('Added file to git repository');
        }

    });
}

var commitGit = (message) => {
    return new Promise((resolve, reject) => {
        if (shell.exec('git commit -m "' + message + '"').code !== 0) {
            reject("Failed to commit changes");
        }
        else {
            resolve("Commited changes");
        }
    })
}

var pushGit = () => {
    return new Promise((resolve, reject) => {
        if (shell.exec('git push origin master').code !== 0) {
            reject("Failed to push to origin master");
        }
        else {
            resolve("Pushed to master");
        }
    })
}

if (command == 'addDir') {
    console.log('Adding directory: ', argv.path);

    addToGit(argv.path, true).then(message => console.log(message)).catch(err => console.log(err));

}
else if (command == 'acp') {

    console.log('ACP started');

    var path = argv.path
    var addToIgnore = false;

    if(fs.exists(path + ignoredFiles[1])){
        addToIgnore = true;
    }

    addToGit(path, addToIgnore).then(message => {
        console.log(message);
        commitGit(argv.message).then(commitMessage => {
            console.log(commitMessage);
            pushGit().then(pushMessage => {
                console.log(pushMessage);
            })
        });
    }).catch(err => {
        console.log(err);
    })

}


