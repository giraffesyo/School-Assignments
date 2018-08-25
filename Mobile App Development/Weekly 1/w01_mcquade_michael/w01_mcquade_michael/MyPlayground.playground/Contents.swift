import UIKit
import w01_mcquade_michael



var Money1 = Cash(money: -1.00)
var Money2 = Cash(money: 0.00)
var Money3 = Cash(money: 54.25)
var Money4 = Cash(money: 4.16)
var Money5 = Cash(money: 99.99)
var Money6 = Cash(money: 47.23)


let bills1: [Int]? = Money1.getBills()
let bills2: [Int]? = Money2.getBills()
let bills3: [Int]? = Money3.getBills()
let bills4: [Int]? = Money4.getBills()
let bills5: [Int]? = Money5.getBills()
let bills6: [Int]? = Money6.getBills()
