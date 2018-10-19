//
//  ViewController.swift
//  W08_McQuade_Michael
//
//  Created by Michael McQuade on 10/17/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet var deptAbbr: UITextField!
    @IBOutlet var courseNum: UITextField!
    @IBOutlet var courseTitle: UITextField!
    
    // Initialize everything
    var deptAbbrResult = ""
    var courseNumResult: Int16 = 0
    var CourseTitleResult = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        // Make ourself the delegate for all the textboxes
        deptAbbr.delegate = self
        courseNum.delegate = self
        courseTitle.delegate = self
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        deptAbbrResult = deptAbbr.text ?? "Bad DeptAbbr"
        courseNumResult = Int16(courseNum.text ?? "-1")!
        CourseTitleResult = courseTitle.text ?? "Bad Title"
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        // If this is the courseNum textfield then we should check that the entry is numeric
        if textField === courseNum {
            //create a character set of the decimal numbers
            let allowedChars = CharacterSet.decimalDigits
            // create a character set out of the typed character (or pasted string)
            let charSet = CharacterSet(charactersIn: string)
            // if the typed character is a subset of our allowed characters, return true, else false
            return allowedChars.isSuperset(of: charSet)
        } else {
            // if we are any other field, just return true, allowing the character
            return true
        }
    }
    
}

