//
//  ViewController.swift
//  W02_mcquade_michael
//
//  Created by Michael McQuade on 8/31/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        
    }

    @IBOutlet weak var displayLabel: UILabel!
    
    @IBAction func numberPressed(_ sender: UIButton) {
        let tappedNumber: Int = Int(sender.titleLabel!.text!)!
        displayLabel.text = sender.titleLabel!.text!
    }
    
}


