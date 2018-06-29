const fs = require('fs');

fs.copyFileSync(process.argv[2], process.argv[2]+'.bak');
const file = fs.readFileSync(process.argv[2], 'utf8')
    // Normalization
    .replace(/[Ss][Tt][Aa][Tt][Ee][Ss]/g, 'States')
    .replace(/[Aa][Cc][Tt][Oo][Rr]/g, 'Actor')
    .replace(/[Dd][Aa][Mm][Aa][Gg][Ee][Ff][Aa][Cc][Tt][Oo][Rr]/g, 'DamageFactor')

    // Bracket style
    .replace(/States\s*\n+\s*{/g, 'States {\n')
    .replace(/Actor (.+)\s*\n+\s*{/g, 'Actor $1 {')

fs.writeFileSync(process.argv[2], file)