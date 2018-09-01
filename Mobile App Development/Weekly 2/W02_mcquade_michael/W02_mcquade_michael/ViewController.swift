//
//  ViewController.swift
//  W02_mcquade_michael
//
//  Created by Michael McQuade on 8/31/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    var history: [Int] = [0]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        
    }

    
    @IBOutlet weak var displayLabel: UILabel!
    
    @IBAction func numberPressed(_ sender: UIButton) {
        let tappedNumber: Int = Int(sender.titleLabel!.text!)!
        let currentValue:Int = Int(displayLabel.text!)!
        let newValue = tappedNumber + currentValue
        displayLabel.text = String(newValue)
        print(history.count)
        history.append(newValue)
        
    }
    
    
    @IBAction func clearPressed(_ sender: UIButton) {
        history = [0]
        displayLabel.text = String(0)
    }
    
    
    @IBAction func undoPressed(_ sender: UIButton) {
        if(history.count > 1){
            history.removeLast()
            displayLabel.text = String(history.last!)
            
        }
        
    }
    
    
}


