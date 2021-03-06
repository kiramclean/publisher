(ns publisher.state
  (:require [reagent.core :as r]))

(defonce db (r/atom {}))
