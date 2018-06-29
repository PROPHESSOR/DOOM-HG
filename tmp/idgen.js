// (Actor \w+ (: \w+)? ){ => $1%ID% {

const START_POINT = 15000;
const MARKER = '%ID%';

const fs = require('fs');

fs.copyFileSync(process.argv[2], process.argv[2]+'.bak');
let file = fs.readFileSync(process.argv[2], 'utf8');


let position = Number(fs.readFileSync(__filename.replace('js', 'stop'), 'utf8')) || START_POINT;

while(file.includes(MARKER)) {
    file = file.replace(MARKER, ++position);
}

fs.writeFileSync(__filename.replace('js', 'stop'), position)

fs.writeFileSync(process.argv[2], file)