//
//  ViewController.swift
//  Aug28
//
//  Created by Michael McQuade on 8/28/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    @IBOutlet weak var myLabel: UILabel!
    
    @IBAction func myButton(_ sender: UIButton) {
        
        myLabel.text = "Bye, World!"
    }
}

